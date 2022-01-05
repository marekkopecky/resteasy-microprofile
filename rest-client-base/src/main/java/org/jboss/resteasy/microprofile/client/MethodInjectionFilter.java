/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2021 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.resteasy.microprofile.client;

import static org.jboss.resteasy.microprofile.client.utils.ClientRequestContextUtils.getMethod;

import java.lang.reflect.Method;

import jakarta.annotation.Priority;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;

@Priority(Integer.MIN_VALUE)
public class MethodInjectionFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) {
        Method method = getMethod(requestContext);
        requestContext.setProperty("org.eclipse.microprofile.rest.client.invokedMethod", method);
    }
}
