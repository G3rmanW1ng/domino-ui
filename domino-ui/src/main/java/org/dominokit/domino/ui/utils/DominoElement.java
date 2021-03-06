package org.dominokit.domino.ui.utils;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.elemento.Elements;
import org.jboss.elemento.IsElement;

public class DominoElement<E extends HTMLElement> extends BaseDominoElement<E, DominoElement<E>> {

    private final E wrappedElement;

    public static <E extends HTMLElement> DominoElement<E> of(E element) {
        return new DominoElement<>(element);
    }

    public static <E extends HTMLElement> DominoElement<E> of(IsElement<E> element) {
        return new DominoElement<>(element.element());
    }

    public static DominoElement<HTMLBodyElement> body() {
        return new DominoElement<>(DomGlobal.document.body);
    }

    public static DominoElement<HTMLDivElement> div() {
        return DominoElement.of(Elements.div());
    }

    public DominoElement(E element) {
        this.wrappedElement = element;
        init(this);
    }

    @Override
    public E element() {
        return wrappedElement;
    }
}
