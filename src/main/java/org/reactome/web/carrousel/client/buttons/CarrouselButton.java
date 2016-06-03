package org.reactome.web.carrousel.client.buttons;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class CarrouselButton extends Button {

    public CarrouselButton(String title, String style, ClickHandler handler) {
        setStyleName(style);
        addClickHandler(handler);
        setTitle(title);
    }
}
