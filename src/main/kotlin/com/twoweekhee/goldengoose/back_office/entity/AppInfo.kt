package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "app_info")
data class AppInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", unique = true, nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "app_name", nullable = false, length = 100)
    val appName: String,
    
    @Column(name = "description", columnDefinition = "TEXT")
    val description: String? = null,
    
    @Column(name = "app_icon_url")
    val appIconUrl: String? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "splash_screen_config", columnDefinition = "JSON")
    val splashScreenConfig: JsonNode? = null,
    
    @Column(name = "status", length = 20)
    val status: String = "DRAFT"
)
