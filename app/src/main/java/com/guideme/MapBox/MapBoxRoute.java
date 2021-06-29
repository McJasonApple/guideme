package com.guideme.MapBox;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.guideme.R;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineCap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineJoin;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineWidth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class MapBoxRoute {

    private MapboxMap mapboxMap;
    private Context context;
    private HashMap<String, String> routeId;


    public MapBoxRoute(MapboxMap mapboxMap, Context context) {
        this.mapboxMap = mapboxMap;
        this.context = context;
        this.routeId = new HashMap<>();
    }

    public void addRoute(ArrayList<Point> points, ArrayList<Integer> trainingsLevels) {
        //create route from points
        Style style = mapboxMap.getStyle();
        String lineSource = UUID.randomUUID().toString();
        style.addSource(new GeoJsonSource(lineSource,
                FeatureCollection.fromFeatures(new Feature[]{Feature.fromGeometry(
                        LineString.fromLngLats(points)
                )}), new GeoJsonOptions().withLineMetrics(true)));

        //add colors
        ArrayList<Expression.Stop> tmpStops = new ArrayList<>();
        int nthElement = 1;
        for (Integer value : trainingsLevels) {
            switch (value) {
                case 1:
                    tmpStops.add(Expression.stop((double) nthElement / trainingsLevels.size(), Expression.rgb(2, 119, 189)));
                    break;
                case 2:
                    tmpStops.add(Expression.stop((double) nthElement / trainingsLevels.size(), Expression.rgb(0, 191, 165)));
                    break;
                case 3:
                    tmpStops.add(Expression.stop((double) nthElement / trainingsLevels.size(), Expression.rgb(0, 191, 165)));
                    break;
                case 4:
                    tmpStops.add(Expression.stop((double) nthElement / trainingsLevels.size(), Expression.rgb(76, 175, 80)));
                    break;
                case 5:
                    tmpStops.add(Expression.stop((double) nthElement / trainingsLevels.size(), Expression.rgb(255, 214, 0)));
                    break;
                case 6:
                    tmpStops.add(Expression.stop((double) nthElement / trainingsLevels.size(), Expression.rgb(255, 87, 34)));
                    break;
                default:
                    tmpStops.add(Expression.stop((double) nthElement / trainingsLevels.size(), Expression.rgb(191, 54, 12)));
            }
            nthElement++;
        }

        Expression.Stop[] stops = new Expression.Stop[tmpStops.size()];
        for (int i = 0; i < tmpStops.size(); i++) {
            stops[i] = tmpStops.get(i);
        }

        String lineLayer = UUID.randomUUID().toString();
        style.addLayer(new LineLayer(lineLayer, lineSource).withProperties(
                PropertyFactory.lineCap(Property.LINE_CAP_ROUND),
                PropertyFactory.lineJoin(Property.LINE_JOIN_ROUND),
                PropertyFactory.lineWidth(5f),
                PropertyFactory.lineGradient(Expression.interpolate(
                        Expression.linear(), Expression.lineProgress(),
                        stops
                ))
        ));

    }
}

