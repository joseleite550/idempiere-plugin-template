package org.template.base.component;

import org.adempiere.webui.factory.AnnotationBasedFormFactory;
import org.adempiere.webui.factory.IFormFactory;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author jose.leite
 *
 */
@Component(immediate = true, service = IFormFactory.class, property = { "service.ranking:Integer=1" })
public class TemplateAnnotationBasedFormFactory extends AnnotationBasedFormFactory {

	@Override
	protected String[] getPackages() {
		return new String[] { "org.template.form" };
	}

}
