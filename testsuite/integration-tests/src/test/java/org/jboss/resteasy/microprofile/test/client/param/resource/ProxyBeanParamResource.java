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

package org.jboss.resteasy.microprofile.test.client.param.resource;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

/**
 * Created by Marek Marusic <mmarusic@redhat.com> on 3/4/19.
 */
@Path("/a")
public class ProxyBeanParamResource {

    @GET
    @Path("a/{p1}/{p2}/{p3}")
    public String getAll(@BeanParam Params beanParam, @PathParam("p2") String p2, @QueryParam String queryParam) {
        return beanParam.getP1() + "_" + p2 + "_" + beanParam.getP3() + "_" + beanParam.getQ1() + "_" + queryParam;
    }
}
