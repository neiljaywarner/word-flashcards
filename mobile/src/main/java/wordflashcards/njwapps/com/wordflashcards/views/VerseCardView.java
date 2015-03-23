package wordflashcards.njwapps.com.wordflashcards.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import wordflashcards.njwapps.com.wordflashcards.R;
import wordflashcards.njwapps.com.wordflashcards.model.Verse;

/**
 * Created by warner on 3/22/15.
 */
public class VerseCardView extends LinearLayout {

    private TextView mTextViewReference;
    private TextView mTextViewVerse;
    private TextView mTextViewTranslation;

    private ImageView mImageViewClose;
    private ImageView mImageViewOpen;
    private View mVerseContainer;
    private View mReferenceContainer;

    public VerseCardView(Context context)	{
        super(context);
        setup(context);
    }

    public VerseCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(context);
        init(attrs, 0);
    }

    public VerseCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setup(context);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.VerseCardView, defStyle, 0);


        int referenceTextColor = a.getColor(
                R.styleable.VerseCardView_verseColor,
                R.color.primary_text_default_material_dark);
        mTextViewReference.setTextColor(referenceTextColor);

        int verseTextColor = a.getColor(
                R.styleable.VerseCardView_verseColor,
                R.color.primary_text_default_material_dark);
        mTextViewVerse.setTextColor(verseTextColor);
        mTextViewTranslation.setTextColor(verseTextColor);

        if (a.hasValue(R.styleable.VerseCardView_closeDrawable)) {

            int closeRefId = a.getResourceId(R.styleable.VerseCardView_closeDrawable, 0);
            if (closeRefId != 0) {
                mImageViewClose.setImageResource(closeRefId);
            }
        }

        if (a.hasValue(R.styleable.VerseCardView_openDrawable)) {

            int openRefId = a.getResourceId(R.styleable.VerseCardView_openDrawable, 0);
            if (openRefId != 0) {
                mImageViewOpen.setImageResource(openRefId);
            }
        }

        if (a.hasValue(R.styleable.VerseCardView_translation)) {
            String translation = a.getString(R.styleable.VerseCardView_translation);
            mTextViewTranslation.setText("(" + translation +")");
        }

        a.recycle();


    }
    public void setup(Context context) {
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.verse_card_view_merge, this);
        mTextViewReference	=	(TextView)	findViewById(R.id.textViewReference);
        mTextViewVerse = (TextView) findViewById(R.id.textViewVerse);
        mTextViewTranslation = (TextView) findViewById(R.id.textViewTranslation);
        mImageViewClose = (ImageView) findViewById(R.id.imageViewClose);
        mImageViewOpen = (ImageView) findViewById(R.id.imageViewOpen);
        mVerseContainer = findViewById(R.id.verseContainer);
        mReferenceContainer = findViewById(R.id.referenceContainer);
        mReferenceContainer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVerseContainer.getVisibility() == View.VISIBLE) {
                    hide();
                } else {
                    show();
                }
            }
        });


    }

    private void hide() {
        mImageViewClose.setVisibility(View.VISIBLE);
        mImageViewOpen.setVisibility(View.GONE);

        //TODO: Animate close
        mVerseContainer.setVisibility(View.GONE);

    }

    private void show() {
        mImageViewClose.setVisibility(View.GONE);
        mImageViewOpen.setVisibility(View.VISIBLE);

        //TODO: Animate open
        mVerseContainer.setVisibility(View.VISIBLE);

    }





    public void bind(Verse verse) {
        mTextViewReference.setText(verse.getReference());
        mTextViewVerse.setText(verse.getText());
    }
}
