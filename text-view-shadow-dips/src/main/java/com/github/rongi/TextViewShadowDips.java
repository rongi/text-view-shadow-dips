package com.github.rongi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.github.rongi.text_view_shadow_dips.R;

public class TextViewShadowDips extends TextView {

	public TextViewShadowDips(Context context, AttributeSet attrs) {
		super(context, attrs);

		final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TextViewShadowDips);

		final float shadowRadius;
		final float shadowDx;
		final float shadowDy;
		final int shadowColor;

		try {
			final float shadowRadiusFromAttributes = attributes.getDimension(R.styleable.TextViewShadowDips_shadowRadius, 0f);
			shadowRadius = shadowRadiusFrom(shadowRadiusFromAttributes);

			shadowDx = attributes.getDimension(R.styleable.TextViewShadowDips_shadowDx, 0f);
			shadowDy = attributes.getDimension(R.styleable.TextViewShadowDips_shadowDy, 0f);

			shadowColor = attributes.getColor(R.styleable.TextViewShadowDips_shadowColor, 0);
		} finally {
			attributes.recycle();
		}

		if (shadowColor != 0) {
			setShadowLayer(shadowRadius, shadowDx, shadowDy, shadowColor);
		} else {
			getPaint().clearShadowLayer();
		}
	}

	private static float shadowRadiusFrom(float shadowRadiusFromAttributes) {
		// App can crash on some devices if shadow radius is more than 25 pixels
		// On Samsung Galaxy S6 this crash happens when you copy a text from an input field
		// https://stackoverflow.com/questions/4866928/ranges-for-radius-in-shadowradius-and-visiblity-in-textview?lq=1
		final float radiusCapped = Math.min(shadowRadiusFromAttributes, 25f);

		// Threat radius between 0 and 1 pixels as 1 pixel to prevent
		// unexpected shadow loss on lower-dpi devices.
		final float radius;
		if (radiusCapped > 0f && radiusCapped < 1f) {
			radius = 1f;
		} else {
			radius = radiusCapped;
		}

		return radius;
	}

}
