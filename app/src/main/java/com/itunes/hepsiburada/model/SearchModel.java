package com.itunes.hepsiburada.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchModel {

    @SerializedName("resultCount")
    @Expose
    public Integer resultCount;
    @SerializedName("results")
    @Expose
    public List<Result> results = null;

    public class Result implements Serializable {

        @SerializedName("wrapperType")
        @Expose
        public String wrapperType;
        @SerializedName("artistId")
        @Expose
        public Integer artistId;
        @SerializedName("collectionId")
        @Expose
        public Integer collectionId;
        @SerializedName("artistName")
        @Expose
        public String artistName;
        @SerializedName("collectionName")
        @Expose
        public String collectionName;
        @SerializedName("collectionCensoredName")
        @Expose
        public String collectionCensoredName;
        @SerializedName("artistViewUrl")
        @Expose
        public String artistViewUrl;
        @SerializedName("collectionViewUrl")
        @Expose
        public String collectionViewUrl;
        @SerializedName("artworkUrl60")
        @Expose
        public String artworkUrl60;
        @SerializedName("artworkUrl100")
        @Expose
        public String artworkUrl100;
        @SerializedName("collectionPrice")
        @Expose
        public Float collectionPrice;
        @SerializedName("collectionExplicitness")
        @Expose
        public String collectionExplicitness;
        @SerializedName("trackCount")
        @Expose
        public Integer trackCount;
        @SerializedName("copyright")
        @Expose
        public String copyright;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("currency")
        @Expose
        public String currency;
        @SerializedName("releaseDate")
        @Expose
        public String releaseDate;
        @SerializedName("primaryGenreName")
        @Expose
        public String primaryGenreName;
        @SerializedName("previewUrl")
        @Expose
        public String previewUrl;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("kind")
        @Expose
        public String kind;
        @SerializedName("trackId")
        @Expose
        public Integer trackId;
        @SerializedName("trackName")
        @Expose
        public String trackName;
        @SerializedName("trackCensoredName")
        @Expose
        public String trackCensoredName;
        @SerializedName("collectionArtistId")
        @Expose
        public Integer collectionArtistId;
        @SerializedName("collectionArtistViewUrl")
        @Expose
        public String collectionArtistViewUrl;
        @SerializedName("trackViewUrl")
        @Expose
        public String trackViewUrl;
        @SerializedName("artworkUrl30")
        @Expose
        public String artworkUrl30;
        @SerializedName("trackPrice")
        @Expose
        public Float trackPrice;
        @SerializedName("collectionHdPrice")
        @Expose
        public Float collectionHdPrice;
        @SerializedName("trackHdPrice")
        @Expose
        public Float trackHdPrice;
        @SerializedName("trackExplicitness")
        @Expose
        public String trackExplicitness;
        @SerializedName("discCount")
        @Expose
        public Integer discCount;
        @SerializedName("discNumber")
        @Expose
        public Integer discNumber;
        @SerializedName("trackNumber")
        @Expose
        public Integer trackNumber;
        @SerializedName("trackTimeMillis")
        @Expose
        public Integer trackTimeMillis;
        @SerializedName("contentAdvisoryRating")
        @Expose
        public String contentAdvisoryRating;
        @SerializedName("longDescription")
        @Expose
        public String longDescription;
        @SerializedName("hasITunesExtras")
        @Expose
        public Boolean hasITunesExtras;
        @SerializedName("isStreamable")
        @Expose
        public Boolean isStreamable;
        @SerializedName("trackRentalPrice")
        @Expose
        public Float trackRentalPrice;
        @SerializedName("trackHdRentalPrice")
        @Expose
        public Float trackHdRentalPrice;
        @SerializedName("shortDescription")
        @Expose
        public String shortDescription;

        public String getWrapperType() {
            return wrapperType;
        }

        public void setWrapperType(String wrapperType) {
            this.wrapperType = wrapperType;
        }

        public Integer getArtistId() {
            return artistId;
        }

        public void setArtistId(Integer artistId) {
            this.artistId = artistId;
        }

        public Integer getCollectionId() {
            return collectionId;
        }

        public void setCollectionId(Integer collectionId) {
            this.collectionId = collectionId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getCollectionName() {
            return collectionName;
        }

        public void setCollectionName(String collectionName) {
            this.collectionName = collectionName;
        }

        public String getCollectionCensoredName() {
            return collectionCensoredName;
        }

        public void setCollectionCensoredName(String collectionCensoredName) {
            this.collectionCensoredName = collectionCensoredName;
        }

        public String getArtistViewUrl() {
            return artistViewUrl;
        }

        public void setArtistViewUrl(String artistViewUrl) {
            this.artistViewUrl = artistViewUrl;
        }

        public String getCollectionViewUrl() {
            return collectionViewUrl;
        }

        public void setCollectionViewUrl(String collectionViewUrl) {
            this.collectionViewUrl = collectionViewUrl;
        }

        public String getArtworkUrl60() {
            return artworkUrl60;
        }

        public void setArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
        }

        public String getArtworkUrl100() {
            return artworkUrl100;
        }

        public void setArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
        }

        public Float getCollectionPrice() {
            return collectionPrice;
        }

        public void setCollectionPrice(Float collectionPrice) {
            this.collectionPrice = collectionPrice;
        }

        public String getCollectionExplicitness() {
            return collectionExplicitness;
        }

        public void setCollectionExplicitness(String collectionExplicitness) {
            this.collectionExplicitness = collectionExplicitness;
        }

        public Integer getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(Integer trackCount) {
            this.trackCount = trackCount;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getPrimaryGenreName() {
            return primaryGenreName;
        }

        public void setPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
        }

        public String getPreviewUrl() {
            return previewUrl;
        }

        public void setPreviewUrl(String previewUrl) {
            this.previewUrl = previewUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public Integer getTrackId() {
            return trackId;
        }

        public void setTrackId(Integer trackId) {
            this.trackId = trackId;
        }

        public String getTrackName() {
            return trackName;
        }

        public void setTrackName(String trackName) {
            this.trackName = trackName;
        }

        public String getTrackCensoredName() {
            return trackCensoredName;
        }

        public void setTrackCensoredName(String trackCensoredName) {
            this.trackCensoredName = trackCensoredName;
        }

        public Integer getCollectionArtistId() {
            return collectionArtistId;
        }

        public void setCollectionArtistId(Integer collectionArtistId) {
            this.collectionArtistId = collectionArtistId;
        }

        public String getCollectionArtistViewUrl() {
            return collectionArtistViewUrl;
        }

        public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
            this.collectionArtistViewUrl = collectionArtistViewUrl;
        }

        public String getTrackViewUrl() {
            return trackViewUrl;
        }

        public void setTrackViewUrl(String trackViewUrl) {
            this.trackViewUrl = trackViewUrl;
        }

        public String getArtworkUrl30() {
            return artworkUrl30;
        }

        public void setArtworkUrl30(String artworkUrl30) {
            this.artworkUrl30 = artworkUrl30;
        }

        public Float getTrackPrice() {
            return trackPrice;
        }

        public void setTrackPrice(Float trackPrice) {
            this.trackPrice = trackPrice;
        }

        public Float getCollectionHdPrice() {
            return collectionHdPrice;
        }

        public void setCollectionHdPrice(Float collectionHdPrice) {
            this.collectionHdPrice = collectionHdPrice;
        }

        public Float getTrackHdPrice() {
            return trackHdPrice;
        }

        public void setTrackHdPrice(Float trackHdPrice) {
            this.trackHdPrice = trackHdPrice;
        }

        public String getTrackExplicitness() {
            return trackExplicitness;
        }

        public void setTrackExplicitness(String trackExplicitness) {
            this.trackExplicitness = trackExplicitness;
        }

        public Integer getDiscCount() {
            return discCount;
        }

        public void setDiscCount(Integer discCount) {
            this.discCount = discCount;
        }

        public Integer getDiscNumber() {
            return discNumber;
        }

        public void setDiscNumber(Integer discNumber) {
            this.discNumber = discNumber;
        }

        public Integer getTrackNumber() {
            return trackNumber;
        }

        public void setTrackNumber(Integer trackNumber) {
            this.trackNumber = trackNumber;
        }

        public Integer getTrackTimeMillis() {
            return trackTimeMillis;
        }

        public void setTrackTimeMillis(Integer trackTimeMillis) {
            this.trackTimeMillis = trackTimeMillis;
        }

        public String getContentAdvisoryRating() {
            return contentAdvisoryRating;
        }

        public void setContentAdvisoryRating(String contentAdvisoryRating) {
            this.contentAdvisoryRating = contentAdvisoryRating;
        }

        public String getLongDescription() {
            return longDescription;
        }

        public void setLongDescription(String longDescription) {
            this.longDescription = longDescription;
        }

        public Boolean getHasITunesExtras() {
            return hasITunesExtras;
        }

        public void setHasITunesExtras(Boolean hasITunesExtras) {
            this.hasITunesExtras = hasITunesExtras;
        }

        public Boolean getStreamable() {
            return isStreamable;
        }

        public void setStreamable(Boolean streamable) {
            isStreamable = streamable;
        }

        public Float getTrackRentalPrice() {
            return trackRentalPrice;
        }

        public void setTrackRentalPrice(Float trackRentalPrice) {
            this.trackRentalPrice = trackRentalPrice;
        }

        public Float getTrackHdRentalPrice() {
            return trackHdRentalPrice;
        }

        public void setTrackHdRentalPrice(Float trackHdRentalPrice) {
            this.trackHdRentalPrice = trackHdRentalPrice;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
