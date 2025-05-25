package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "app_theme")
data class AppTheme(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", unique = true, nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "theme_name", nullable = false, length = 50)
    val themeName: String,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "color_scheme", nullable = false, columnDefinition = "JSON")
    val colorScheme: JsonNode,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "typography", nullable = false, columnDefinition = "JSON")
    val typography: JsonNode,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "spacing", nullable = false, columnDefinition = "JSON")
    val spacing: JsonNode,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "border_radius", nullable = false, columnDefinition = "JSON")
    val borderRadius: JsonNode,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "shadow_config", columnDefinition = "JSON")
    val shadowConfig: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "animation_config", columnDefinition = "JSON")
    val animationConfig: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
