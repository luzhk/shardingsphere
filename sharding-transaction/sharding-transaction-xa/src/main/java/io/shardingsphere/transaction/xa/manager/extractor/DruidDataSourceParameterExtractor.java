/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.transaction.xa.manager.extractor;

import io.shardingsphere.core.config.DataSourceConfiguration;

import javax.sql.DataSource;

/**
 * Extract datasource parameter from Druid connection pool.
 *
 * @author zhaojun
 */
public final class DruidDataSourceParameterExtractor extends DefaultDataSourceParameterExtractor {
    
    DruidDataSourceParameterExtractor(final DataSource dataSource) {
        super(dataSource);
    }
    
    @Override
    protected void convertProperties() {
        DataSourceConfiguration dataSourceConfiguration = getDataSourceConfiguration();
        dataSourceConfiguration.getProperties().put("url", dataSourceConfiguration.getProperties().get("jdbcUrl"));
        dataSourceConfiguration.getProperties().put("maximumPoolSize", dataSourceConfiguration.getProperties().get("maxActive"));
        dataSourceConfiguration.getProperties().put("idleTimeout", dataSourceConfiguration.getProperties().get("maxIdle"));
        dataSourceConfiguration.getProperties().put("connectionTimeout", dataSourceConfiguration.getProperties().get("minEvictableIdleTimeMillis"));
    }
}
