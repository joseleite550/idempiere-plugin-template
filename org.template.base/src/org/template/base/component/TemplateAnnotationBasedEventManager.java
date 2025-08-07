package org.template.base.component;


import org.adempiere.base.AnnotationBasedEventManager;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author jose.leite
 *
 */
@Component(immediate = true, service = {})
public class TemplateAnnotationBasedEventManager extends AnnotationBasedEventManager {

	@Override
	public String[] getPackages() {
		return new String[] { "org.vex.event" };
	}

}
