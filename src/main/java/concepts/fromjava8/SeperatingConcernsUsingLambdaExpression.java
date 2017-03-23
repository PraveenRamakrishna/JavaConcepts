package concepts.fromjava8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import concepts.fromjava8.Asset.AssetType;

/**
 * We often create classes to reuse code, but its not always right choice, by using high-order functions we can accomplish 
 * same goals without needing a hierarchy of classes. 
 */
public class SeperatingConcernsUsingLambdaExpression {

	public static void main(String[] args) {
	
		//Exploring Design Concerns - Plan is to mix multiple concerns in one method, but will
		//quickly re-factor to make it more cohesive.
		
		//Asset is simple JavaBean with two properties - Type & Value
		final List<Asset> assets = Arrays.asList(new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.BOND, 2000), new Asset(Asset.AssetType.STOCK, 3000),
				new Asset(Asset.AssetType.STOCK, 4000));
		
		System.out.println("Total Value of Assets: " + totalAllAssetValues(assets));
		
		System.out.println("Total Value of Bonds: " + totalBondValues(assets));
		
		System.out.println("Total Value of Stock: "+ totalStockValues(assets));
		
		System.out.println("Re-factored code:");
		
		System.out.println("Total Value of Assets: " + totalAssetValues(assets, asset -> true ));
		
		System.out.println("Total Value of Bonds: " + totalAssetValues(assets, asset -> asset.getType()==AssetType.BOND));
		
		System.out.println("Total Value of Stock: "+ totalAssetValues(assets, asset -> asset.getType()==AssetType.STOCK));		
	}
	
	// Requirement - Lets total values of all the assets given
	private static int totalAllAssetValues(final List<Asset> assets) {
		return assets.stream()
				.mapToInt(Asset::getValue)
				.sum();
	}
	
	//Requirement - Lets total only Bond value
	private static int totalBondValues(final List<Asset> assets) {
		return assets.stream()
				.filter(asset -> asset.getType().equals(AssetType.BOND))
				.mapToInt(Asset::getValue)
				.sum();
	}
	
	//Requirement - Lets total only Stock value
	private static int totalStockValues(final List<Asset> assets) {
		return assets.stream()
				.filter(asset -> asset.getType().equals(AssetType.STOCK))
				.mapToInt(Asset::getValue)
				.sum();
	}
	
	//Re-factoring to separate a key concern - in above 3 methods iteration & way we total is same, only difference is "What to total"
	//re-factored method using "Open/Closed Principle" - we can easily change selection criteria without changing method. 
	private static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector){
		return assets.stream()
				.filter(assetSelector)
				.mapToInt(Asset::getValue)
				.sum();		
	}
}
