package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "image_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class ImageStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "width_type", length = 20)
    val widthType: String? = null,
    
    @Column(name = "width_value")
    val widthValue: Int? = null,
    
    @Column(name = "height_type", length = 20)
    val heightType: String? = null,
    
    @Column(name = "height_value")
    val heightValue: Int? = null,
    
    @Column(name = "aspect_ratio", length = 20)
    val aspectRatio: String? = null,
    
    @Column(name = "resize_mode", length = 20)
    val resizeMode: String? = null,
    
    @Column(name = "border_radius")
    val borderRadius: Int? = null,
    
    @Column(name = "border_width")
    val borderWidth: Int? = null,
    
    @Column(name = "border_color", length = 20)
    val borderColor: String? = null,
    
    @Column(name = "opacity", precision = 3, scale = 2)
    val opacity: Double? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "filters", columnDefinition = "JSON")
    val filters: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "placeholder_config", columnDefinition = "JSON")
    val placeholderConfig: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "loading_config", columnDefinition = "JSON")
    val loadingConfig: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
