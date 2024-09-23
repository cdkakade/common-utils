package expense.manager.common.security.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
		;
		Collection<String> roles;
		if (realmAccess == null || realmAccess.isEmpty()) {
			return Set.of();
		}
		if (realmAccess.get("roles") == null)
			return Set.of();

		roles = (Collection<String>) realmAccess.get("roles");

		return roles.stream()
			.map(roleName -> "ROLE_" + roleName)
			.map(SimpleGrantedAuthority::new)
			.collect(Collectors.toSet());
	}

}
