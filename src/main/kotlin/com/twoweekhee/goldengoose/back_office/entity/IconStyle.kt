package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "icon_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class IconStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "icon_family", length = 30)
    val iconFamily: String? = null,
    
    @Column(name = "size", nullable = false)
    val size: Int,
    
    @Column(name = "color", length = 20)
    val color: String? = null,
    
    @Column(name = "background_color", length = 20)
    val backgroundColor: String? = null,
    
    @Column(name = "border_radius")
    val borderRadius: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "padding", columnDefinition = "JSON")
    val padding: JsonNode? = null,
    
    @Column(name = "opacity", precision = 3, scale = 2)
    val opacity: Double? = null,
    
    @Column(name = "rotation")
    val rotation: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "animation_config", columnDefinition = "JSON")
    val animationConfig: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
