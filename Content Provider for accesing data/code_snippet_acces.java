Intent intent = new Intent();
intent.setAction(Intent.ACTION_VIEW);
intent.setDataAndType( Uri.parse("content://com.SBL.eDinette/" + imageFile), "image/*" );
EDinetteActivity.MainContext.startActivity(intent);
