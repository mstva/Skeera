package tech.mstava.skeera.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_home.view.*
import tech.mstava.skeera.R
import kotlin.reflect.KClass


class HomeFragment : Fragment(R.layout.fragment_home), NavigationView.OnNavigationItemSelectedListener {

    var scoreGameCardList: List<ScoreGameCard>? = null
    private var drawerLayout: DrawerLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.drawer_nav_home, container, false)

        scoreGameCardList = ArrayList(
            listOf(
                ScoreGameCard("Football", R.drawable.ic_football),
                ScoreGameCard("Volleyball", R.drawable.ic_volleyball),
                ScoreGameCard("Tennis", R.drawable.ic_tennis),
                ScoreGameCard("Squash", R.drawable.squash)
            )
        )

        val scoreGameViewAdapter = ScoreGameViewAdapter(this.requireContext(), scoreGameCardList)
        view.recyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        view.recyclerView.adapter = scoreGameViewAdapter

        drawerLayout = view.findViewById(R.id.drawer_home_nav)

        val navView = view.findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        return view
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.football_game -> openActivity(TeamsActivity::class.java)
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    private fun openActivity(ActivityToOpen: Class<out Activity?>) {
        val intent = Intent(activity, ActivityToOpen)
        startActivity(intent)
    }


}