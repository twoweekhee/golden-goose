package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "modal_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class ModalStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "modal_type", nullable = false, length = 30)
    val modalType: String,
    
    @Column(name = "overlay_color", length = 20)
    val overlayColor: String? = null,
    
    @Column(name = "overlay_opacity", precision = 3, scale = 2)
    val overlayOpacity: Double? = null,
    
    @Column(name = "modal_background_color", length = 20)
    val modalBackgroundColor: String? = null,
    
    @Column(name = "modal_border_radius")
    val modalBorderRadius: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "modal_padding", columnDefinition = "JSON")
    val modalPadding: JsonNode? = null,
    
    @Column(name = "animation_type", length = 30)
    val animationType: String? = null,
    
    @Column(name = "animation_duration")
    val animationDuration: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "shadow_config", columnDefinition = "JSON")
    val shadowConfig: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "close_button_style", columnDefinition = "JSON")
    val closeButtonStyle: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
