package com.twoweekhee.goldengoose.back_office.controller

import com.twoweekhee.goldengoose.back_office.entity.AppTheme
import com.twoweekhee.goldengoose.back_office.service.AppThemeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/themes")
@CrossOrigin(origins = ["*"])
class AppThemeController(
    private val appThemeService: AppThemeService
) {
    
    @PostMapping
    fun createTheme(@RequestBody appTheme: AppTheme): ResponseEntity<AppTheme> {
        return try {
            val createdTheme = appThemeService.createTheme(appTheme)
            ResponseEntity.status(HttpStatus.CREATED).body(createdTheme)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping
    fun getAllThemes(): ResponseEntity<List<AppTheme>> {
        val themes = appThemeService.getAllThemes()
        return ResponseEntity.ok(themes)
    }
    
    @GetMapping("/{id}")
    fun getThemeById(@PathVariable id: Long): ResponseEntity<AppTheme> {
        val theme = appThemeService.getThemeById(id)
        return if (theme != null) {
            ResponseEntity.ok(theme)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @GetMapping("/app/{appId}")
    fun getThemeByAppId(@PathVariable appId: String): ResponseEntity<AppTheme> {
        val theme = appThemeService.getThemeByAppId(appId)
        return if (theme != null) {
            ResponseEntity.ok(theme)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @PutMapping("/{id}")
    fun updateTheme(@PathVariable id: Long, @RequestBody appTheme: AppTheme): ResponseEntity<AppTheme> {
        val updatedTheme = appThemeService.updateTheme(id, appTheme)
        return if (updatedTheme != null) {
            ResponseEntity.ok(updatedTheme)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @PutMapping("/app/{appId}")
    fun updateThemeByAppId(@PathVariable appId: String, @RequestBody appTheme: AppTheme): ResponseEntity<AppTheme> {
        val updatedTheme = appThemeService.updateThemeByAppId(appId, appTheme)
        return if (updatedTheme != null) {
            ResponseEntity.ok(updatedTheme)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @DeleteMapping("/{id}")
    fun deleteTheme(@PathVariable id: Long): ResponseEntity<Void> {
        return if (appThemeService.deleteTheme(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @DeleteMapping("/app/{appId}")
    fun deleteThemeByAppId(@PathVariable appId: String): ResponseEntity<Void> {
        return if (appThemeService.deleteThemeByAppId(appId)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
