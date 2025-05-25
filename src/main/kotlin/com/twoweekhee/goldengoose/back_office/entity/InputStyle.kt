package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "input_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class InputStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "input_type", nullable = false, length = 30)
    val inputType: String,
    
    @Column(name = "background_color", length = 20)
    val backgroundColor: String? = null,
    
    @Column(name = "border_color", length = 20)
    val borderColor: String? = null,
    
    @Column(name = "border_width")
    val borderWidth: Int = 1,
    
    @Column(name = "border_radius")
    val borderRadius: Int? = null,
    
    @Column(name = "text_color", length = 20)
    val textColor: String? = null,
    
    @Column(name = "placeholder_color", length = 20)
    val placeholderColor: String? = null,
    
    @Column(name = "font_size")
    val fontSize: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "padding", columnDefinition = "JSON")
    val padding: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "label_style", columnDefinition = "JSON")
    val labelStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "error_style", columnDefinition = "JSON")
    val errorStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "focus_style", columnDefinition = "JSON")
    val focusStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "disabled_style", columnDefinition = "JSON")
    val disabledStyle: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
