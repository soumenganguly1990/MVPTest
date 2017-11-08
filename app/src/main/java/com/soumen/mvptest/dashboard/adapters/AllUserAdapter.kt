package com.soumen.mvptest.dashboard.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.soumen.mvptest.dashboard.viewholders.UserViewHolder
import com.soumen.mvptest.roomcommonops.entities.UserEntity
import android.view.LayoutInflater
import android.view.View
import com.soumen.mvptest.R

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class AllUserAdapter: RecyclerView.Adapter<UserViewHolder> {

    var mContext: Context? = null
    var userList: ArrayList<UserEntity>? = null

    /* click listener */
    public interface AllUserClickListener {
        fun onDeleteUserClick(position: Int)
        fun onViewPasswordClick(position: Int)
    }
    private lateinit var allUserClickListener: AllUserClickListener

    constructor(mContext: Context?, userList: ArrayList<UserEntity>, allUserClickListener: AllUserClickListener) {
        this.mContext = mContext
        this.userList = userList
        this.allUserClickListener = allUserClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        var view: View = LayoutInflater.from(mContext!!).inflate(R.layout.item_alluser, parent, false)
        var userViewHolder: UserViewHolder = UserViewHolder(view, allUserClickListener)
        return userViewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        Log.e("bind viewholder", "bindViewHolder called for " + userList!!.get(position).getUserId())
        holder!!.txtItemUserId.text = userList!!.get(position).getUserId()
        holder!!.txtItemUserEmail.text = userList!!.get(position).getEmail()
        holder!!.txtItemUserPhone.text = userList!!.get(position).getPhone().toString()
    }

    override fun getItemCount(): Int {
        return if (null != userList) userList!!.size else 0
    }
}