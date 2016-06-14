package com.googlesource.gerrit.plugins.avatars.dummyavatar;

import com.google.gerrit.extensions.annotations.Listen;
import com.google.gerrit.server.IdentifiedUser;
import com.google.gerrit.server.avatar.AvatarProvider;
import com.google.gerrit.server.config.CanonicalWebUrl;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Listen
@Singleton
public class DummyAvatarProvider implements AvatarProvider {
  private final String canonicalUrl;

  @Inject
  DummyAvatarProvider(@CanonicalWebUrl String canonicalUrl) {
    this.canonicalUrl = canonicalUrl;
  }

  @Override
  public String getUrl(IdentifiedUser forUser, int imageSize) {
    return canonicalUrl + "static/photo.png"; 
  }

  @Override
  public String getChangeAvatarUrl(IdentifiedUser forUser) {
    return null;
  }
}
