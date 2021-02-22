/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ir.moke.gwt.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import ir.moke.gwt.client.component.home.Home;
import ir.moke.gwt.client.component.product.Product;

public class MainTemplate extends Composite {
    interface MainTemplateBinder extends UiBinder<Widget, MainTemplate> {
    }

    @UiField
    Anchor homeLink;

    @UiField
    Anchor productLink;

    @UiField
    HTMLPanel content;

    private static final MainTemplateBinder templateBinder = GWT.create(MainTemplateBinder.class);
    private static final Home home = new Home();
    private static final Product product = new Product();

    public MainTemplate() {
        initWidget(templateBinder.createAndBindUi(this));
        content.add(home);

        homeLink.addClickHandler(event -> {
            content.clear();
            content.add(home);
        });
        productLink.addClickHandler(event -> {
            content.clear();
            content.add(product);
        });
    }
}
