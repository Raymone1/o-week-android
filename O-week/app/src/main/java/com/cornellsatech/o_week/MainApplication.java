package com.cornellsatech.o_week;


import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.cornellsatech.o_week.models.CollegeType;
import com.cornellsatech.o_week.models.InternationalStudentStatus;
import com.cornellsatech.o_week.models.StudentType;
import com.cornellsatech.o_week.util.Settings;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * The entry point into the app. Initialize all singletons, static variables, or anything that should only
 * run once when the app launches here.
 */
public class MainApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		JodaTimeAndroid.init(this);
		UserData.loadData(this);

		//if the user never filled out his info, he need to do so.
		if(Settings.getStudentSavedType(this) == StudentType.NOTSET || Settings.getStudentSavedInternationalStatus(this) == InternationalStudentStatus.NOTSET || Settings.getStudentSavedCollegeType(this) == CollegeType.NOTSET) {
			Intent intent = new Intent(this, InitialSettingsActivity.class);
			startActivity(intent);
		}
	}
}
