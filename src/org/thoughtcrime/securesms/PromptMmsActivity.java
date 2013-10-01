package org.thoughtcrime.securesms;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class PromptMmsActivity extends PassphraseRequiredSherlockActivity {

  private Button okButton;
  private Button cancelButton;

  @Override
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.prompt_apn_activity);

    initializeResources();
  }

  private void initializeResources() {
    this.okButton     = (Button)findViewById(R.id.ok_button);
    this.cancelButton = (Button)findViewById(R.id.cancel_button);

    this.okButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        handleEditApnPreferences();
      }
    });

    this.cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }

  private void handleEditApnPreferences() {
    PreferenceManager.getDefaultSharedPreferences(this).edit()
        .putBoolean(ApplicationPreferencesActivity.USE_LOCAL_MMS_APNS_PREF, true).commit();

    Intent intent = new Intent(this, ApnPreferencesActivity.class);
    intent.putExtras(this.getIntent().getExtras());
    startActivity(intent);
  }

}