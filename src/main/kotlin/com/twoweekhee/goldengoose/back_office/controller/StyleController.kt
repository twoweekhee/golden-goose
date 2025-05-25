package com.twoweekhee.goldengoose.back_office.controller

import com.twoweekhee.goldengoose.back_office.entity.*
import com.twoweekhee.goldengoose.back_office.service.StyleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/styles")
@CrossOrigin(origins = ["*"])
class StyleController(
    private val styleService: StyleService
) {
    
    // Button Style Endpoints
    @PostMapping("/buttons")
    fun createButtonStyle(@RequestBody buttonStyle: ButtonStyle): ResponseEntity<ButtonStyle> {
        return try {
            val created = styleService.createButtonStyle(buttonStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/buttons/app/{appId}")
    fun getButtonStylesByAppId(@PathVariable appId: String): ResponseEntity<List<ButtonStyle>> {
        val styles = styleService.getButtonStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/buttons/app/{appId}/style/{styleName}")
    fun getButtonStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<ButtonStyle> {
        val style = styleService.getButtonStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/buttons/{id}")
    fun updateButtonStyle(@PathVariable id: Long, @RequestBody buttonStyle: ButtonStyle): ResponseEntity<ButtonStyle> {
        val updated = styleService.updateButtonStyle(id, buttonStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/buttons/{id}")
    fun deleteButtonStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteButtonStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Card Style Endpoints
    @PostMapping("/cards")
    fun createCardStyle(@RequestBody cardStyle: CardStyle): ResponseEntity<CardStyle> {
        return try {
            val created = styleService.createCardStyle(cardStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/cards/app/{appId}")
    fun getCardStylesByAppId(@PathVariable appId: String): ResponseEntity<List<CardStyle>> {
        val styles = styleService.getCardStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/cards/app/{appId}/style/{styleName}")
    fun getCardStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<CardStyle> {
        val style = styleService.getCardStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/cards/{id}")
    fun updateCardStyle(@PathVariable id: Long, @RequestBody cardStyle: CardStyle): ResponseEntity<CardStyle> {
        val updated = styleService.updateCardStyle(id, cardStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/cards/{id}")
    fun deleteCardStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteCardStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Input Style Endpoints
    @PostMapping("/inputs")
    fun createInputStyle(@RequestBody inputStyle: InputStyle): ResponseEntity<InputStyle> {
        return try {
            val created = styleService.createInputStyle(inputStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/inputs/app/{appId}")
    fun getInputStylesByAppId(@PathVariable appId: String): ResponseEntity<List<InputStyle>> {
        val styles = styleService.getInputStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/inputs/app/{appId}/style/{styleName}")
    fun getInputStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<InputStyle> {
        val style = styleService.getInputStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/inputs/{id}")
    fun updateInputStyle(@PathVariable id: Long, @RequestBody inputStyle: InputStyle): ResponseEntity<InputStyle> {
        val updated = styleService.updateInputStyle(id, inputStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/inputs/{id}")
    fun deleteInputStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteInputStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // List Style Endpoints
    @PostMapping("/lists")
    fun createListStyle(@RequestBody listStyle: ListStyle): ResponseEntity<ListStyle> {
        return try {
            val created = styleService.createListStyle(listStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/lists/app/{appId}")
    fun getListStylesByAppId(@PathVariable appId: String): ResponseEntity<List<ListStyle>> {
        val styles = styleService.getListStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/lists/app/{appId}/style/{styleName}")
    fun getListStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<ListStyle> {
        val style = styleService.getListStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/lists/{id}")
    fun updateListStyle(@PathVariable id: Long, @RequestBody listStyle: ListStyle): ResponseEntity<ListStyle> {
        val updated = styleService.updateListStyle(id, listStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/lists/{id}")
    fun deleteListStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteListStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Navigation Style Endpoints
    @PostMapping("/navigations")
    fun createNavigationStyle(@RequestBody navigationStyle: NavigationStyle): ResponseEntity<NavigationStyle> {
        return try {
            val created = styleService.createNavigationStyle(navigationStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/navigations/app/{appId}")
    fun getNavigationStylesByAppId(@PathVariable appId: String): ResponseEntity<List<NavigationStyle>> {
        val styles = styleService.getNavigationStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/navigations/app/{appId}/nav-type/{navType}/style/{styleName}")
    fun getNavigationStyleByAppIdAndNavTypeAndStyleName(
        @PathVariable appId: String,
        @PathVariable navType: String,
        @PathVariable styleName: String
    ): ResponseEntity<NavigationStyle> {
        val style = styleService.getNavigationStyleByAppIdAndNavTypeAndStyleName(appId, navType, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/navigations/{id}")
    fun updateNavigationStyle(@PathVariable id: Long, @RequestBody navigationStyle: NavigationStyle): ResponseEntity<NavigationStyle> {
        val updated = styleService.updateNavigationStyle(id, navigationStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/navigations/{id}")
    fun deleteNavigationStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteNavigationStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Text Style Endpoints
    @PostMapping("/texts")
    fun createTextStyle(@RequestBody textStyle: TextStyle): ResponseEntity<TextStyle> {
        return try {
            val created = styleService.createTextStyle(textStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/texts/app/{appId}")
    fun getTextStylesByAppId(@PathVariable appId: String): ResponseEntity<List<TextStyle>> {
        val styles = styleService.getTextStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/texts/app/{appId}/style/{styleName}")
    fun getTextStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<TextStyle> {
        val style = styleService.getTextStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/texts/{id}")
    fun updateTextStyle(@PathVariable id: Long, @RequestBody textStyle: TextStyle): ResponseEntity<TextStyle> {
        val updated = styleService.updateTextStyle(id, textStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/texts/{id}")
    fun deleteTextStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteTextStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Image Style Endpoints
    @PostMapping("/images")
    fun createImageStyle(@RequestBody imageStyle: ImageStyle): ResponseEntity<ImageStyle> {
        return try {
            val created = styleService.createImageStyle(imageStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/images/app/{appId}")
    fun getImageStylesByAppId(@PathVariable appId: String): ResponseEntity<List<ImageStyle>> {
        val styles = styleService.getImageStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/images/app/{appId}/style/{styleName}")
    fun getImageStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<ImageStyle> {
        val style = styleService.getImageStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/images/{id}")
    fun updateImageStyle(@PathVariable id: Long, @RequestBody imageStyle: ImageStyle): ResponseEntity<ImageStyle> {
        val updated = styleService.updateImageStyle(id, imageStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/images/{id}")
    fun deleteImageStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteImageStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Layout Style Endpoints
    @PostMapping("/layouts")
    fun createLayoutStyle(@RequestBody layoutStyle: LayoutStyle): ResponseEntity<LayoutStyle> {
        return try {
            val created = styleService.createLayoutStyle(layoutStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/layouts/app/{appId}")
    fun getLayoutStylesByAppId(@PathVariable appId: String): ResponseEntity<List<LayoutStyle>> {
        val styles = styleService.getLayoutStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/layouts/app/{appId}/style/{styleName}")
    fun getLayoutStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<LayoutStyle> {
        val style = styleService.getLayoutStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/layouts/{id}")
    fun updateLayoutStyle(@PathVariable id: Long, @RequestBody layoutStyle: LayoutStyle): ResponseEntity<LayoutStyle> {
        val updated = styleService.updateLayoutStyle(id, layoutStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/layouts/{id}")
    fun deleteLayoutStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteLayoutStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Modal Style Endpoints
    @PostMapping("/modals")
    fun createModalStyle(@RequestBody modalStyle: ModalStyle): ResponseEntity<ModalStyle> {
        return try {
            val created = styleService.createModalStyle(modalStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/modals/app/{appId}")
    fun getModalStylesByAppId(@PathVariable appId: String): ResponseEntity<List<ModalStyle>> {
        val styles = styleService.getModalStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/modals/app/{appId}/style/{styleName}")
    fun getModalStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<ModalStyle> {
        val style = styleService.getModalStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/modals/{id}")
    fun updateModalStyle(@PathVariable id: Long, @RequestBody modalStyle: ModalStyle): ResponseEntity<ModalStyle> {
        val updated = styleService.updateModalStyle(id, modalStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/modals/{id}")
    fun deleteModalStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteModalStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Icon Style Endpoints
    @PostMapping("/icons")
    fun createIconStyle(@RequestBody iconStyle: IconStyle): ResponseEntity<IconStyle> {
        return try {
            val created = styleService.createIconStyle(iconStyle)
            ResponseEntity.status(HttpStatus.CREATED).body(created)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }
    
    @GetMapping("/icons/app/{appId}")
    fun getIconStylesByAppId(@PathVariable appId: String): ResponseEntity<List<IconStyle>> {
        val styles = styleService.getIconStylesByAppId(appId)
        return ResponseEntity.ok(styles)
    }
    
    @GetMapping("/icons/app/{appId}/style/{styleName}")
    fun getIconStyleByAppIdAndStyleName(
        @PathVariable appId: String,
        @PathVariable styleName: String
    ): ResponseEntity<IconStyle> {
        val style = styleService.getIconStyleByAppIdAndStyleName(appId, styleName)
        return if (style != null) ResponseEntity.ok(style) else ResponseEntity.notFound().build()
    }
    
    @PutMapping("/icons/{id}")
    fun updateIconStyle(@PathVariable id: Long, @RequestBody iconStyle: IconStyle): ResponseEntity<IconStyle> {
        val updated = styleService.updateIconStyle(id, iconStyle)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/icons/{id}")
    fun deleteIconStyle(@PathVariable id: Long): ResponseEntity<Void> {
        return if (styleService.deleteIconStyle(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    
    // Utility Endpoints
    @DeleteMapping("/app/{appId}/all")
    fun deleteAllStylesByAppId(@PathVariable appId: String): ResponseEntity<Map<String, Int>> {
        val deletedCounts = styleService.deleteAllStylesByAppId(appId)
        return ResponseEntity.ok(deletedCounts)
    }
}
