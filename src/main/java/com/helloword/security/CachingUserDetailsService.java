package com.helloword.security;

import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by scnyig on 12/19/2017.
 */
@Service
public class CachingUserDetailsService implements UserDetailsService {
    private UserCache userCache = new NullUserCache();
    private final UserDetailsService delegate;

    CachingUserDetailsService(UserDetailsServiceCustom delegate) {
        this.delegate = delegate;
    }

    public UserCache getUserCache() {
        return userCache;
    }

    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userCache.getUserFromCache(username);

        if (user == null) {
            user = delegate.loadUserByUsername(username);
        }

        if(null == user) {
            return user;
        }
        Assert.notNull(user, "UserDetailsService" + delegate + "returned null for username" + username + "." +
                "This is an interface contract violation");

        userCache.putUserInCache(user);

        return user;
    }
}
