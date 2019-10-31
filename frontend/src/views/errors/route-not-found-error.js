import {PolymerElement} from '@polymer/polymer/polymer-element.js';
import '../../../styles/shared-styles.js';
import {html} from '@polymer/polymer/lib/utils/html-tag.js';

class RouteNotFoundError extends PolymerElement {
    static get template() {
        return html`
    <h3 style="text-align: center">
      Sayfa Bulunamadı.
    </h3>
`;
    }

    static get is() {
        return 'route-not-found-error';
    }
}

customElements.define(RouteNotFoundError.is, RouteNotFoundError);
