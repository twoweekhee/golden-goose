package com.twoweekhee.goldengoose.back_office.controller

import com.twoweekhee.goldengoose.back_office.entity.AppInfo
import com.twoweekhee.goldengoose.back_office.service.AppInfoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/apps")
@CrossOrigin(origins = ["*"])
class AppInfoController(
    private val appInfoService: AppInfoService
) {
    
    @PostMapping
    fun createApp(@RequestBody appInfo: AppInfo): ResponseEntity<AppInfo> {
        return try {
            val createdApp = appInfoService.createApp(appInfo)
            ResponseEntity.status(HttpStatus.CREATED).body(createdApp)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping
    fun getAllApps(): ResponseEntity<List<AppInfo>> {
        val apps = appInfoService.getAllApps()
        return ResponseEntity.ok(apps)
    }
    
    @GetMapping("/{id}")
    fun getAppById(@PathVariable id: Long): ResponseEntity<AppInfo> {
        val app = appInfoService.getAppById(id)
        return if (app != null) {
            ResponseEntity.ok(app)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @GetMapping("/app-id/{appId}")
    fun getAppByAppId(@PathVariable appId: String): ResponseEntity<AppInfo> {
        val app = appInfoService.getAppByAppId(appId)
        return if (app != null) {
            ResponseEntity.ok(app)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @GetMapping("/status/{status}")
    fun getAppsByStatus(@PathVariable status: String): ResponseEntity<List<AppInfo>> {
        val apps = appInfoService.getAppsByStatus(status)
        return ResponseEntity.ok(apps)
    }
    
    @PutMapping("/{id}")
    fun updateApp(@PathVariable id: Long, @RequestBody appInfo: AppInfo): ResponseEntity<AppInfo> {
        val updatedApp = appInfoService.updateApp(id, appInfo)
        return if (updatedApp != null) {
            ResponseEntity.ok(updatedApp)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @DeleteMapping("/{id}")
    fun deleteApp(@PathVariable id: Long): ResponseEntity<Void> {
        return if (appInfoService.deleteApp(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @DeleteMapping("/app-id/{appId}")
    fun deleteAppByAppId(@PathVariable appId: String): ResponseEntity<Void> {
        return if (appInfoService.deleteAppByAppId(appId)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    @GetMapping("/exists/{appId}")
    fun checkAppExists(@PathVariable appId: String): ResponseEntity<Map<String, Boolean>> {
        val exists = appInfoService.existsByAppId(appId)
        return ResponseEntity.ok(mapOf("exists" to exists))
    }
}
