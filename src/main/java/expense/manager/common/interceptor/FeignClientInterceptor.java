package expense.manager.common.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate requestTemplate) {
		// Get the JWT from the SecurityContext
		Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (jwt != null) {
			String token = jwt.getTokenValue();
			// Add Authorization header with the Bearer token
			requestTemplate.header("Authorization", "Bearer " + token);
		}
	}

}
