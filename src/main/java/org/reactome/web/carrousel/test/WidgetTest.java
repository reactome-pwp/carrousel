package org.reactome.web.carrousel.test;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import org.reactome.web.carrousel.client.CarrouselPanel;
import org.reactome.web.carrousel.client.Slide;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class WidgetTest implements EntryPoint {

    @Override
    public void onModuleLoad() {
        List<Slide> slides = new LinkedList<>();
        slides.add(new Slide(RESOURCES.slide01(), "You can import and overlay your data<br>onto pathways by defining custom resources", "white", 18));
        slides.add(new Slide(RESOURCES.slide02(), "A custom resource can be defined by providing a<br>local or network-stored file or a PSICQUIC service", "white", 18));
        slides.add(new Slide(RESOURCES.slide03(), "The simplest way to submit data is in a two-column file<br>(tsv/csv) with the interactors defined in columns 1 and 2", "white", 18));
        slides.add(new Slide(RESOURCES.slide04(), "The extended tuple format offers more options (alias, scores, etc).<br>This information will be displayed and used in the overlay", "white", 18));

        CarrouselPanel carrousel = new CarrouselPanel(slides, 600, 400);

        RootLayoutPanel.get().add(carrousel);
    }

    public static Resources RESOURCES;

    static {
        RESOURCES = GWT.create(Resources.class);
    }

    /**
     * A ClientBundle of resources used by this widget.
     */
    public interface Resources extends ClientBundle {

        @Source("slide_01.png")
        ImageResource slide01();

        @Source("slide_02.png")
        ImageResource slide02();

        @Source("slide_03.png")
        ImageResource slide03();

        @Source("slide_04.png")
        ImageResource slide04();
    }
}
