package io.github.andraantariksa.crates.feature_crates.data.source.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object SettingsDataStore {
    const val NAME = "settings"
}

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SettingsDataStore.NAME)
