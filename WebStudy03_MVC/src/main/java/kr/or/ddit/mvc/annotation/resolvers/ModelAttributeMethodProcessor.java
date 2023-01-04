package kr.or.ddit.mvc.annotation.resolvers;

import java.io.IOException;
import java.lang.reflect.Parameter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.apache.commons.text.WordUtils;

/**
 * @ModelAttribute 어노테이션을 가진 command object(not 기본형) 인자 하나를 해결
 *  ex) @ModelAttribute MemberVO member (O);
 *  	@ModelAttribute int cp (X);
 */
public class ModelAttributeMethodProcessor implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(Parameter parameter) {
		Class<?> parameterType = parameter.getType();
		ModelAttribute modelAttribute = parameter.getAnnotation(ModelAttribute.class);
		boolean support = modelAttribute != null
					&&
				!(
					parameterType.isPrimitive()
					 ||
					String.class.equals(parameterType)
					 ||
					(parameterType.isArray()
					 && (
							parameterType.getComponentType().isPrimitive()
							||
							parameterType.getComponentType().equals(String.class)
						)
					)
				);
		return support;
	}

	@Override
	public Object resolveArgument(Parameter parameter, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Class<?> parameterType = parameter.getType();
		ModelAttribute modelAttribute = parameter.getAnnotation(ModelAttribute.class);
		try {
			//		MemberVO member = new MemberVO();
			Object commandObject = parameterType.newInstance();
			
			//		req.setAttribute("member", member);
			String attrName = modelAttribute.value();
	//		CoC(Convention over Configuration) - 주로 spring에서 적극적으로 활용
			if(StringUtils.isBlank(attrName)) {
				attrName = WordUtils.uncapitalize(parameterType.getSimpleName());
			}
			req.setAttribute(attrName, commandObject);
			
			
			//		Map<String, String[]> parameterMap = req.getParameterMap();
			//		// 전달되는 파라미터와 그걸 받는 칭구의 이름이 같아야할 것 memId=memId
			//		try {
			//			BeanUtils.populate(member, parameterMap);
			//		} catch (IllegalAccessException | InvocationTargetException e) {
			//			throw new RuntimeException(e);
			//		}
			BeanUtils.populate(commandObject, req.getParameterMap());
		
			return commandObject;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
