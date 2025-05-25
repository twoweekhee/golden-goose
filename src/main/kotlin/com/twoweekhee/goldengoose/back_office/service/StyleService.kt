package com.twoweekhee.goldengoose.back_office.service

import com.twoweekhee.goldengoose.back_office.entity.*
import com.twoweekhee.goldengoose.back_office.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StyleService(
    private val buttonStyleRepository: ButtonStyleRepository,
    private val cardStyleRepository: CardStyleRepository,
    private val inputStyleRepository: InputStyleRepository,
    private val listStyleRepository: ListStyleRepository,
    private val navigationStyleRepository: NavigationStyleRepository,
    private val textStyleRepository: TextStyleRepository,
    private val imageStyleRepository: ImageStyleRepository,
    private val layoutStyleRepository: LayoutStyleRepository,
    private val modalStyleRepository: ModalStyleRepository,
    private val iconStyleRepository: IconStyleRepository
) {
    
    // Button Style Methods
    fun createButtonStyle(buttonStyle: ButtonStyle): ButtonStyle {
        buttonStyleRepository.findByAppIdAndStyleName(buttonStyle.appId, buttonStyle.styleName)?.let {
            throw IllegalArgumentException("Button style '${buttonStyle.styleName}' for app '${buttonStyle.appId}' already exists")
        }
        return buttonStyleRepository.save(buttonStyle)
    }
    
    @Transactional(readOnly = true)
    fun getButtonStylesByAppId(appId: String): List<ButtonStyle> = buttonStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getButtonStyleByAppIdAndStyleName(appId: String, styleName: String): ButtonStyle? = 
        buttonStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateButtonStyle(id: Long, buttonStyle: ButtonStyle): ButtonStyle? =
        if (buttonStyleRepository.existsById(id)) buttonStyleRepository.save(buttonStyle.copy(id = id)) else null
    
    fun deleteButtonStyle(id: Long): Boolean =
        if (buttonStyleRepository.existsById(id)) { buttonStyleRepository.deleteById(id); true } else false
    
    // Card Style Methods
    fun createCardStyle(cardStyle: CardStyle): CardStyle {
        cardStyleRepository.findByAppIdAndStyleName(cardStyle.appId, cardStyle.styleName)?.let {
            throw IllegalArgumentException("Card style '${cardStyle.styleName}' for app '${cardStyle.appId}' already exists")
        }
        return cardStyleRepository.save(cardStyle)
    }
    
    @Transactional(readOnly = true)
    fun getCardStylesByAppId(appId: String): List<CardStyle> = cardStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getCardStyleByAppIdAndStyleName(appId: String, styleName: String): CardStyle? = 
        cardStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateCardStyle(id: Long, cardStyle: CardStyle): CardStyle? =
        if (cardStyleRepository.existsById(id)) cardStyleRepository.save(cardStyle.copy(id = id)) else null
    
    fun deleteCardStyle(id: Long): Boolean =
        if (cardStyleRepository.existsById(id)) { cardStyleRepository.deleteById(id); true } else false
    
    // Input Style Methods
    fun createInputStyle(inputStyle: InputStyle): InputStyle {
        inputStyleRepository.findByAppIdAndStyleName(inputStyle.appId, inputStyle.styleName)?.let {
            throw IllegalArgumentException("Input style '${inputStyle.styleName}' for app '${inputStyle.appId}' already exists")
        }
        return inputStyleRepository.save(inputStyle)
    }
    
    @Transactional(readOnly = true)
    fun getInputStylesByAppId(appId: String): List<InputStyle> = inputStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getInputStyleByAppIdAndStyleName(appId: String, styleName: String): InputStyle? = 
        inputStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateInputStyle(id: Long, inputStyle: InputStyle): InputStyle? =
        if (inputStyleRepository.existsById(id)) inputStyleRepository.save(inputStyle.copy(id = id)) else null
    
    fun deleteInputStyle(id: Long): Boolean =
        if (inputStyleRepository.existsById(id)) { inputStyleRepository.deleteById(id); true } else false
    
    // List Style Methods
    fun createListStyle(listStyle: ListStyle): ListStyle {
        listStyleRepository.findByAppIdAndStyleName(listStyle.appId, listStyle.styleName)?.let {
            throw IllegalArgumentException("List style '${listStyle.styleName}' for app '${listStyle.appId}' already exists")
        }
        return listStyleRepository.save(listStyle)
    }
    
    @Transactional(readOnly = true)
    fun getListStylesByAppId(appId: String): List<ListStyle> = listStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getListStyleByAppIdAndStyleName(appId: String, styleName: String): ListStyle? = 
        listStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateListStyle(id: Long, listStyle: ListStyle): ListStyle? =
        if (listStyleRepository.existsById(id)) listStyleRepository.save(listStyle.copy(id = id)) else null
    
    fun deleteListStyle(id: Long): Boolean =
        if (listStyleRepository.existsById(id)) { listStyleRepository.deleteById(id); true } else false
    
    // Navigation Style Methods
    fun createNavigationStyle(navigationStyle: NavigationStyle): NavigationStyle {
        navigationStyleRepository.findByAppIdAndNavTypeAndStyleName(
            navigationStyle.appId, navigationStyle.navType, navigationStyle.styleName
        )?.let {
            throw IllegalArgumentException("Navigation style '${navigationStyle.styleName}' for app '${navigationStyle.appId}' and nav type '${navigationStyle.navType}' already exists")
        }
        return navigationStyleRepository.save(navigationStyle)
    }
    
    @Transactional(readOnly = true)
    fun getNavigationStylesByAppId(appId: String): List<NavigationStyle> = navigationStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getNavigationStyleByAppIdAndNavTypeAndStyleName(appId: String, navType: String, styleName: String): NavigationStyle? = 
        navigationStyleRepository.findByAppIdAndNavTypeAndStyleName(appId, navType, styleName)
    
    fun updateNavigationStyle(id: Long, navigationStyle: NavigationStyle): NavigationStyle? =
        if (navigationStyleRepository.existsById(id)) navigationStyleRepository.save(navigationStyle.copy(id = id)) else null
    
    fun deleteNavigationStyle(id: Long): Boolean =
        if (navigationStyleRepository.existsById(id)) { navigationStyleRepository.deleteById(id); true } else false
    
    // Text Style Methods
    fun createTextStyle(textStyle: TextStyle): TextStyle {
        textStyleRepository.findByAppIdAndStyleName(textStyle.appId, textStyle.styleName)?.let {
            throw IllegalArgumentException("Text style '${textStyle.styleName}' for app '${textStyle.appId}' already exists")
        }
        return textStyleRepository.save(textStyle)
    }
    
    @Transactional(readOnly = true)
    fun getTextStylesByAppId(appId: String): List<TextStyle> = textStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getTextStyleByAppIdAndStyleName(appId: String, styleName: String): TextStyle? = 
        textStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateTextStyle(id: Long, textStyle: TextStyle): TextStyle? =
        if (textStyleRepository.existsById(id)) textStyleRepository.save(textStyle.copy(id = id)) else null
    
    fun deleteTextStyle(id: Long): Boolean =
        if (textStyleRepository.existsById(id)) { textStyleRepository.deleteById(id); true } else false
    
    // Image Style Methods
    fun createImageStyle(imageStyle: ImageStyle): ImageStyle {
        imageStyleRepository.findByAppIdAndStyleName(imageStyle.appId, imageStyle.styleName)?.let {
            throw IllegalArgumentException("Image style '${imageStyle.styleName}' for app '${imageStyle.appId}' already exists")
        }
        return imageStyleRepository.save(imageStyle)
    }
    
    @Transactional(readOnly = true)
    fun getImageStylesByAppId(appId: String): List<ImageStyle> = imageStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getImageStyleByAppIdAndStyleName(appId: String, styleName: String): ImageStyle? = 
        imageStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateImageStyle(id: Long, imageStyle: ImageStyle): ImageStyle? =
        if (imageStyleRepository.existsById(id)) imageStyleRepository.save(imageStyle.copy(id = id)) else null
    
    fun deleteImageStyle(id: Long): Boolean =
        if (imageStyleRepository.existsById(id)) { imageStyleRepository.deleteById(id); true } else false
    
    // Layout Style Methods
    fun createLayoutStyle(layoutStyle: LayoutStyle): LayoutStyle {
        layoutStyleRepository.findByAppIdAndStyleName(layoutStyle.appId, layoutStyle.styleName)?.let {
            throw IllegalArgumentException("Layout style '${layoutStyle.styleName}' for app '${layoutStyle.appId}' already exists")
        }
        return layoutStyleRepository.save(layoutStyle)
    }
    
    @Transactional(readOnly = true)
    fun getLayoutStylesByAppId(appId: String): List<LayoutStyle> = layoutStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getLayoutStyleByAppIdAndStyleName(appId: String, styleName: String): LayoutStyle? = 
        layoutStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateLayoutStyle(id: Long, layoutStyle: LayoutStyle): LayoutStyle? =
        if (layoutStyleRepository.existsById(id)) layoutStyleRepository.save(layoutStyle.copy(id = id)) else null
    
    fun deleteLayoutStyle(id: Long): Boolean =
        if (layoutStyleRepository.existsById(id)) { layoutStyleRepository.deleteById(id); true } else false
    
    // Modal Style Methods
    fun createModalStyle(modalStyle: ModalStyle): ModalStyle {
        modalStyleRepository.findByAppIdAndStyleName(modalStyle.appId, modalStyle.styleName)?.let {
            throw IllegalArgumentException("Modal style '${modalStyle.styleName}' for app '${modalStyle.appId}' already exists")
        }
        return modalStyleRepository.save(modalStyle)
    }
    
    @Transactional(readOnly = true)
    fun getModalStylesByAppId(appId: String): List<ModalStyle> = modalStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getModalStyleByAppIdAndStyleName(appId: String, styleName: String): ModalStyle? = 
        modalStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateModalStyle(id: Long, modalStyle: ModalStyle): ModalStyle? =
        if (modalStyleRepository.existsById(id)) modalStyleRepository.save(modalStyle.copy(id = id)) else null
    
    fun deleteModalStyle(id: Long): Boolean =
        if (modalStyleRepository.existsById(id)) { modalStyleRepository.deleteById(id); true } else false
    
    // Icon Style Methods
    fun createIconStyle(iconStyle: IconStyle): IconStyle {
        iconStyleRepository.findByAppIdAndStyleName(iconStyle.appId, iconStyle.styleName)?.let {
            throw IllegalArgumentException("Icon style '${iconStyle.styleName}' for app '${iconStyle.appId}' already exists")
        }
        return iconStyleRepository.save(iconStyle)
    }
    
    @Transactional(readOnly = true)
    fun getIconStylesByAppId(appId: String): List<IconStyle> = iconStyleRepository.findByAppId(appId)
    
    @Transactional(readOnly = true)
    fun getIconStyleByAppIdAndStyleName(appId: String, styleName: String): IconStyle? = 
        iconStyleRepository.findByAppIdAndStyleName(appId, styleName)
    
    fun updateIconStyle(id: Long, iconStyle: IconStyle): IconStyle? =
        if (iconStyleRepository.existsById(id)) iconStyleRepository.save(iconStyle.copy(id = id)) else null
    
    fun deleteIconStyle(id: Long): Boolean =
        if (iconStyleRepository.existsById(id)) { iconStyleRepository.deleteById(id); true } else false
    
    // Utility Methods
    fun deleteAllStylesByAppId(appId: String): Map<String, Int> {
        return mapOf(
            "buttonStyles" to buttonStyleRepository.deleteByAppId(appId),
            "cardStyles" to cardStyleRepository.deleteByAppId(appId),
            "inputStyles" to inputStyleRepository.deleteByAppId(appId),
            "listStyles" to listStyleRepository.deleteByAppId(appId),
            "navigationStyles" to navigationStyleRepository.deleteByAppId(appId),
            "textStyles" to textStyleRepository.deleteByAppId(appId),
            "imageStyles" to imageStyleRepository.deleteByAppId(appId),
            "layoutStyles" to layoutStyleRepository.deleteByAppId(appId),
            "modalStyles" to modalStyleRepository.deleteByAppId(appId),
            "iconStyles" to iconStyleRepository.deleteByAppId(appId)
        )
    }
}
