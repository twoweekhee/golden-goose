package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "layout_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class LayoutStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "layout_type", nullable = false, length = 30)
    val layoutType: String,
    
    @Column(name = "flex_direction", length = 20)
    val flexDirection: String? = null,
    
    @Column(name = "justify_content", length = 30)
    val justifyContent: String? = null,
    
    @Column(name = "align_items", length = 30)
    val alignItems: String? = null,
    
    @Column(name = "flex_wrap", length = 20)
    val flexWrap: String? = null,
    
    @Column(name = "gap")
    val gap: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "padding", columnDefinition = "JSON")
    val padding: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "margin", columnDefinition = "JSON")
    val margin: JsonNode? = null,
    
    @Column(name = "background_color", length = 20)
    val backgroundColor: String? = null,
    
    @Column(name = "background_image_url")
    val backgroundImageUrl: String? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "background_config", columnDefinition = "JSON")
    val backgroundConfig: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "border_config", columnDefinition = "JSON")
    val borderConfig: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
