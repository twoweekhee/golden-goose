package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "card_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class CardStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "background_color", length = 20)
    val backgroundColor: String? = null,
    
    @Column(name = "border_color", length = 20)
    val borderColor: String? = null,
    
    @Column(name = "border_width")
    val borderWidth: Int = 0,
    
    @Column(name = "border_radius")
    val borderRadius: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "shadow_config", columnDefinition = "JSON")
    val shadowConfig: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "padding", columnDefinition = "JSON")
    val padding: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "margin", columnDefinition = "JSON")
    val margin: JsonNode? = null,
    
    @Column(name = "elevation")
    val elevation: Int = 2,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "header_style", columnDefinition = "JSON")
    val headerStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "content_style", columnDefinition = "JSON")
    val contentStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "footer_style", columnDefinition = "JSON")
    val footerStyle: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
