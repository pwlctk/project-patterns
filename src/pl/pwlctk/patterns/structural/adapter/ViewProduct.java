package pl.pwlctk.patterns.structural.adapter;

public class ViewProduct {
    private final ResourceProduct resourceProduct;
    public ViewProduct(ResourceProduct resourceProduct) {
        this.resourceProduct = resourceProduct;
    }

    void show(){
        System.out.println(resourceProduct.getPicture());
        System.out.println();
        System.out.println(resourceProduct.getContent());
    }


}
