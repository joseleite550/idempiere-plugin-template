package org.template.base.component;

import org.adempiere.base.AnnotationBasedProcessFactory;
import org.adempiere.base.IProcessFactory;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author jose.leite
 *
 */
@Component(immediate = true, service = IProcessFactory.class, property = { "service.ranking:Integer=1" })
public class TemplateAnnotationBasedProcessFactory extends AnnotationBasedProcessFactory {

	@Override
	protected String[] getPackages() {
		return new String[] { "org.vex.process" };
	}

}
