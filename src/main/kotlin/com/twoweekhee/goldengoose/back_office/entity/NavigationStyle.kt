package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "navigation_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "nav_type", "style_name"])]
)
data class NavigationStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "nav_type", nullable = false, length = 30)
    val navType: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "background_color", length = 20)
    val backgroundColor: String? = null,
    
    @Column(name = "active_color", length = 20)
    val activeColor: String? = null,
    
    @Column(name = "inactive_color", length = 20)
    val inactiveColor: String? = null,
    
    @Column(name = "indicator_color", length = 20)
    val indicatorColor: String? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "text_style", columnDefinition = "JSON")
    val textStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "icon_style", columnDefinition = "JSON")
    val iconStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "animation_config", columnDefinition = "JSON")
    val animationConfig: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "layout_config", columnDefinition = "JSON")
    val layoutConfig: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
