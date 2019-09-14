package testgroup.nordiccars.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

/*
Еще один момент. Возможно будут проблемы с кодировкой, когда при отправке с формы значений с русскими символами в результате будут получаться каракули.
Для решения этой проблемы добавим фильтр, который будет заниматься предварительной обработкой запросов.
Заходим в класс AppInitializer и переопределяем метод getServletFilters, в котором укажем нужную кодировку,
она разумеется должна быть такой же как и везде, как на страницах и в базе данных:
*/
	protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }	
}
