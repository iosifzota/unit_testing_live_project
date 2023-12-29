package com.assetco.hotspots.optimization;

import com.assetco.search.results.Asset;
import com.assetco.search.results.AssetVendor;
import com.assetco.search.results.AssetVendorRelationshipLevel;
import com.assetco.search.results.HotspotKey;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

class BugsTest {

    @Test
    void precedingPartnerWithLongTrailingAssetsDoesNotWin() {
        var partnerVendor = makeVendor(AssetVendorRelationshipLevel.Partner);
        var missing = givenAssetInResultsWithVendor(partnerVendor);
        var otherVendor = makeVendor(AssetVendorRelationshipLevel.Partner);
        // disrupting asset
        givenAssetInResultsWithVendor(otherVendor);
        var expected = givenFourAssetsInResultsWithVendor(partnerVendor);
        whenOptimize();
        thenHotspotDoesNotHave(HotspotKey.Showcase, missing);
        thenHotspotHasExactly(HotspotKey.Showcase, expected);
    }

    private void thenHotspotHasExactly(HotspotKey hotspotKey, List<Asset> expectedAssets) {
    }

    private void thenHotspotDoesNotHave(HotspotKey hotspotKey, Asset... assets) {
    }

    private void whenOptimize() {
        // empty
    }

    private List<Asset> givenFourAssetsInResultsWithVendor(AssetVendor vendor) {
        var assets = new ArrayList<Asset>();
        for (int count = 1; count <= 4; ++count) {
            assets.add(givenAssetInResultsWithVendor(vendor));
        }
        return assets;
    }

    private Asset givenAssetInResultsWithVendor(AssetVendor vendor) {
        return null;
    }

    private AssetVendor makeVendor(AssetVendorRelationshipLevel assetVendorRelationshipLevel) {
        return null;
    }
}