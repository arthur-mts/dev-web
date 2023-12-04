package com.ifpb.devweb.projetodevweb.configuration

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JDBIConfiguration {
    @Bean
    fun jdbi(dataSourceProperties: DataSourceProperties): Jdbi {
        return with(Jdbi.create(dataSourceProperties.url, dataSourceProperties.username, dataSourceProperties.password)) {
            registerArgument(UUIDArgumentFactory())
            installPlugin(KotlinPlugin())
            this
        }
    }
}