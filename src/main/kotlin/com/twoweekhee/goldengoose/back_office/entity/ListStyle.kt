package com.twoweekhee.goldengoose.back_office.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(
    name = "list_style",
    uniqueConstraints = [UniqueConstraint(columnNames = ["app_id", "style_name"])]
)
data class ListStyle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(name = "app_id", nullable = false, length = 50)
    val appId: String,
    
    @Column(name = "style_name", nullable = false, length = 50)
    val styleName: String,
    
    @Column(name = "list_type", nullable = false, length = 30)
    val listType: String,
    
    @Column(name = "item_spacing")
    val itemSpacing: Int? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "item_style", nullable = false, columnDefinition = "JSON")
    val itemStyle: JsonNode,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "divider_style", columnDefinition = "JSON")
    val dividerStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "header_style", columnDefinition = "JSON")
    val headerStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "footer_style", columnDefinition = "JSON")
    val footerStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "empty_state_style", columnDefinition = "JSON")
    val emptyStateStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "loading_style", columnDefinition = "JSON")
    val loadingStyle: JsonNode? = null,
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "selection_style", columnDefinition = "JSON")
    val selectionStyle: JsonNode? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", referencedColumnName = "app_id", insertable = false, updatable = false)
    val appInfo: AppInfo? = null
)
