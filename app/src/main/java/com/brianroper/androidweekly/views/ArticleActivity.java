package com.brianroper.androidweekly.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.brianroper.androidweekly.R;
import com.brianroper.androidweekly.presenters.ArticlePresenter;
import com.brianroper.androidweekly.services.ArchiveService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleActivity extends AppCompatActivity implements ArticleView {

    @BindView(R.id.article_toolbar)
    public Toolbar mToolbar;
    @BindView(R.id.article_recycler)
    public RecyclerView mRecyclerView;

    private ArticlePresenter mArticlePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        ButterKnife.bind(this);

        initializePresenter();

        handleToolbarBehavior(mToolbar);
    }

    /**
     * handles toolbar behavior
     */
    public void handleToolbarBehavior(Toolbar toolbar){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Android Weekly");
    }

    /**
     * initializes the presenter for this activity and attaches it to the view
     */
    public void initializePresenter(){
        mArticlePresenter = new ArticlePresenter(getApplicationContext());
        mArticlePresenter.attachView(this);
        mArticlePresenter.startArticleService();
    }
}
