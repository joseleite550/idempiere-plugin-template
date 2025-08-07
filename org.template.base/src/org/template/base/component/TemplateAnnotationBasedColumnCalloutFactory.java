package org.template.base.component;

import org.adempiere.base.AnnotationBasedColumnCalloutFactory;
import org.adempiere.base.IColumnCalloutFactory;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author jose.leite
 *
 */
@Component(immediate = true, service = IColumnCalloutFactory.class)
public class TemplateAnnotationBasedColumnCalloutFactory extends AnnotationBasedColumnCalloutFactory {

	@Override
	protected String[] getPackages() {
		return new String[] { "org.template.callout" };
	}

}
