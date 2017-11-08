package com.soumen.mvptest.dashboard.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.soumen.mvptest.R
import com.soumen.mvptest.dashboard.adapters.AllUserAdapter
import com.soumen.mvptest.dashboard.presenter.AllUserPresenterImpl
import com.soumen.mvptest.dashboard.presenter.IAllUserPresenter
import com.soumen.mvptest.dashboard.view.IAllUsersView
import com.soumen.mvptest.extras.AppCommonValues
import com.soumen.mvptest.roomcommonops.entities.UserEntity
import android.support.v7.widget.DividerItemDecoration
import android.util.Log
import android.widget.Toast

/**
 * Created by IN-LT-51 on 07-11-2017.
 */
class AllUserFragment: Fragment(), IAllUsersView, AllUserAdapter.AllUserClickListener {

    @BindView(R.id.txtAllUserDet)
    lateinit var txtAllUserDet: TextView
    @BindView(R.id.rclAllUser)
    lateinit var rclAllUser: RecyclerView

    lateinit var allUserAdapter: AllUserAdapter

    /* all user list object */
    var userList: ArrayList<UserEntity>? = null
    var selectedUserForDeletion: UserEntity? = null

    /* interface object for presenter */
    lateinit var iAllUserPresenter: IAllUserPresenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_all_user, container, false)
        ButterKnife.bind(this, view)
        iAllUserPresenter = AllUserPresenterImpl(this)
        iAllUserPresenter.retrieveUserListFromRoomDb()
        Log.e("alluser frag", "oncreateview called")
        return view
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onAllUserListRetrieved(users: ArrayList<UserEntity>?) {
        userList = users
        if(userList == null || userList!!.size == 0) {
            txtAllUserDet.visibility = View.VISIBLE
            txtAllUserDet.text = "Sorry, no users found"
        } else if(userList!!.size == 1) {
            txtAllUserDet.visibility = View.VISIBLE
            txtAllUserDet.text = "You are the only user"
        } else {
            txtAllUserDet.visibility = View.GONE
            rclAllUser.visibility = View.VISIBLE

            allUserAdapter = AllUserAdapter(AppCommonValues.context!!, userList!!, this)

            var layoutManager: LinearLayoutManager = LinearLayoutManager(AppCommonValues.context!!)
            rclAllUser.layoutManager = layoutManager

            var dividerItemDecoration = DividerItemDecoration(rclAllUser.getContext(), layoutManager.orientation)
            dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.alluser_divider))
            rclAllUser.addItemDecoration(dividerItemDecoration)
            rclAllUser.adapter = allUserAdapter
        }
    }

    override fun onSelectedUserDeleted(status: Int) {
        if(status == 1) {
            userList!!.remove(selectedUserForDeletion)
            allUserAdapter.notifyDataSetChanged()
        } else {
            Toast.makeText(this.activity, "User could not be deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeleteUserClick(position: Int) {
        selectedUserForDeletion = userList!!.get(position)
        iAllUserPresenter.deleteUserFromRoomDb(userList!!.get(position))
    }

    override fun onViewPasswordClick(position: Int) {
        Toast.makeText(this.activity, "Password is " + userList!!.get(position).getPassword(), Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun reloadFragmentUponRequest(fragment: Fragment) {
            val ft = fragment.fragmentManager.beginTransaction()
            ft.detach(fragment).attach(fragment).commit()
        }
    }
}