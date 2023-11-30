package com.ifpb.devweb.projetodevweb

import org.jdbi.v3.core.Handle
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.annotation.RequestScope

@Configuration
class JDBIConfiguration {
    @Bean
    fun jdbi(dataSourceProperties: DataSourceProperties): Jdbi {
        return with(Jdbi.create(dataSourceProperties.url, dataSourceProperties.username, dataSourceProperties.password)) {
            installPlugin(KotlinPlugin())
            this
        }
    }
}