package com.soumen.mvptest.dashboard.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.soumen.mvptest.R
import com.soumen.mvptest.dashboard.adapters.AllUserAdapter

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class UserViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

    @BindView(R.id.txtItemUserId) lateinit var txtItemUserId: TextView
    @BindView(R.id.txtItemUserEmail) public lateinit var txtItemUserEmail: TextView
    @BindView(R.id.txtItemUserPhone) public lateinit var txtItemUserPhone: TextView
    @BindView(R.id.txtDeleteUser) public lateinit var txtDeleteUser: TextView
    @BindView(R.id.txtSeePassword) public lateinit var txtSeePassword: TextView

    /* click listener interface */
    lateinit var allUserClickListener: AllUserAdapter.AllUserClickListener

    constructor(itemView: View?, allUserClickListener: AllUserAdapter.AllUserClickListener): super(itemView) {
        ButterKnife.bind(this, itemView!!)
        txtDeleteUser.setOnClickListener(this)
        txtSeePassword.setOnClickListener(this)
        this.allUserClickListener = allUserClickListener
    }

    override fun onClick(view: View?) {
        if(view == txtDeleteUser) {
            allUserClickListener.onDeleteUserClick(adapterPosition)
        }
        if(view == txtSeePassword) {
            allUserClickListener.onViewPasswordClick(adapterPosition)
        }
    }
}