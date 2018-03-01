package com.shop.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.shop.entity.User;

/**
 * api to get current user or user id
 */
public interface UserUtil {

    /**
     * Method gets user id from security context. To get user id user must be authorized
     * @return user id
     */
    static Integer getSignedUpUserId() {
        final SecurityContext ctx = SecurityContextHolder.getContext();

        if (ctx != null) {
            final Authentication auth = ctx.getAuthentication();

            if (auth != null) {
                final Object principal = auth.getPrincipal();

                if (principal instanceof User) {
                    final User au = (User) principal;
                    return au.getId();
                }
            }
        }

        return (int) 0;
    }

    /**
     * @return authorized user
     */
    static User getSignedUpUser() {
        final SecurityContext ctx = SecurityContextHolder.getContext();

        if (ctx != null) {
            final Authentication auth = ctx.getAuthentication();

            if (auth != null) {
                final Object principal = auth.getPrincipal();

                if (principal instanceof User) {

                    //FIX Consider simply returning the value vs storing it in local variable 'au'
                    //final User au = (User) principal;
                    return (User) principal;
                }
            }
        }
        return null;
    }
}
