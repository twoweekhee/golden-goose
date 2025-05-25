package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "text_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class TextStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "font_family", length = 50)
    val fontFamily: String? = null,
    
    @Column(name = "font_size", nullable = false)
    val fontSize: Int,
    
    @Column(name = "font_weight", length = 20)
    val fontWeight: String? = null,
    
    @Column(name = "font_style", length = 20)
    val fontStyle: String? = null,
    
    @Column(name = "text_color", length = 20)
    val textColor: String? = null,
    
    @Column(name = "line_height", precision = 3, scale = 2)
    val lineHeight: Double? = null,
    
    @Column(name = "letter_spacing", precision = 3, scale = 2)
    val letterSpacing: Double? = null,
    
    @Column(name = "text_align", length = 20)
    val textAlign: String? = null,
    
    @Column(name = "text_decoration", length = 30)
    val textDecoration: String? = null,
    
    @Column(name = "text_transform", length = 20)
    val textTransform: String? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "margin", columnDefinition = "JSON")
    val margin: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "padding", columnDefinition = "JSON")
    val padding: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
