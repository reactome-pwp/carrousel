package org.reactome.web.carrousel.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * This class holds the content of a single carousel slide
 * and its size is defined by the CarrouselPanel.
 *
 * @author Kostas Sidiropoulos <ksidiro@ebi.ac.uk>
 */
public class Slide extends AbsolutePanel {
    private ImageResource imageResource;
    private Widget caption;
    private boolean isInitialized = false;

    public Slide(ImageResource imageResource, String caption, String textColour) {
        this.imageResource = imageResource;
        this.caption = new SimplePanel();
        this.caption.getElement().setInnerHTML(caption);
        getElement().getStyle().setColor(textColour);
    }

    public Slide(ImageResource imageResource, String caption, String textColour, double fontSize) {
        this.imageResource = imageResource;
        this.caption = new SimplePanel();
        this.caption.getElement().getStyle().setFontSize(fontSize, Style.Unit.PX);
        this.caption.getElement().setInnerHTML(caption);
        getElement().getStyle().setColor(textColour);
    }

    public Slide(ImageResource imageResource, Widget caption, String textColour) {
        this.imageResource = imageResource;
        this.caption = caption;
        getElement().getStyle().setColor(textColour);
    }

    public void init(int width, int height) {
        if (isInitialized) return;

        Image image = new Image(imageResource);
        image.setWidth(width + "px");
        image.setHeight(height + "px");

        caption.addStyleName(RESOURCES.getCSS().caption());
        Style style = caption.getElement().getStyle();
        style.setWidth(width, Style.Unit.PX);
        style.setTextAlign(Style.TextAlign.CENTER);

        add(image, 0, 0);
        add(caption);
        isInitialized = true;
    }

    /**
     * Sets the size of the slide container
     */
    public void setSlideSize(int width, int height) {
        Style style = getElement().getStyle();
        style.setWidth(width, Style.Unit.PX);
        style.setHeight(height, Style.Unit.PX);
        style.setFloat(Style.Float.LEFT);
    }

    public static Resources RESOURCES;

    static {
        RESOURCES = GWT.create(Resources.class);
        RESOURCES.getCSS().ensureInjected();
    }

    /**
     * A ClientBundle of resources used by this widget.
     */
    public interface Resources extends ClientBundle {
        /**
         * The styles used in this widget.
         */
        @Source(ResourceCSS.CSS)
        ResourceCSS getCSS();
    }

    /**
     * Styles used by this widget.
     */
    @CssResource.ImportedWithPrefix("diagram-Slide")
    public interface ResourceCSS extends CssResource {
        /**
         * The path to the default CSS styles used by this resource.
         */
        String CSS = "org/reactome/web/carrousel/client/Slide.css";

        String caption();
    }

}
