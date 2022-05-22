package kg.geektech.taskapp.domain

class GetShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemID: Int):ShopItem{
        return shopListRepository.getShopItem(shopItemID)
    }

}