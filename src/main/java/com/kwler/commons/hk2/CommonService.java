package com.kwler.commons.hk2;

import com.kwler.commons.aws.RequestSigner;
import com.kwler.commons.cryptography.DigestService;
import com.kwler.commons.cryptography.HMacService;
import com.kwler.commons.datetime.DatetimeService;
import com.kwler.commons.db.bandsintown.nosql.mongo.dao.BandsInTownDAO;
import com.kwler.commons.db.bandsintown.nosql.mongo.dao.BandsInTownMorphiaDAO;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.blog.nosql.mongo.dao.BlogItemDAO;
import com.kwler.commons.db.blog.nosql.mongo.dao.BlogItemMorphiaDAO;
import com.kwler.commons.db.chart.nosql.mongo.dao.ArtistSummaryDAO;
import com.kwler.commons.db.chart.nosql.mongo.dao.ArtistSummaryMorphiaDAO;
import com.kwler.commons.db.chart.nosql.mongo.dao.ChartItemDAO;
import com.kwler.commons.db.chart.nosql.mongo.dao.ChartItemMorphiaDAO;
import com.kwler.commons.db.discovery.nosql.mongo.dao.ArtistDiscoveryDAO;
import com.kwler.commons.db.discovery.nosql.mongo.dao.ArtistDiscoveryMorphiaDAO;
import com.kwler.commons.db.facebook.nosql.mongo.dao.FacebookEventResultDAO;
import com.kwler.commons.db.facebook.nosql.mongo.dao.FacebookEventResultMorphiaDAO;
import com.kwler.commons.db.facebook.nosql.mongo.dao.FacebookPostResultDAO;
import com.kwler.commons.db.facebook.nosql.mongo.dao.FacebookPostResultMorphiaDAO;
import com.kwler.commons.db.facebook.nosql.mongo.dao.FacebookResultDAO;
import com.kwler.commons.db.facebook.nosql.mongo.dao.FacebookResultMorphiaDAO;
import com.kwler.commons.db.instagram.nosql.mongo.dao.InstagramResultDAO;
import com.kwler.commons.db.instagram.nosql.mongo.dao.InstagramResultMorphiaDAO;
import com.kwler.commons.db.itunes.nosql.mongo.dao.ItunesResultDAO;
import com.kwler.commons.db.itunes.nosql.mongo.dao.ItunesResultMorphiaDAO;
import com.kwler.commons.db.itunes.nosql.mongo.dao.ItunesResultSpotifyTrackDAO;
import com.kwler.commons.db.itunes.nosql.mongo.dao.ItunesResultSpotifyTrackMorphiaDAO;
import com.kwler.commons.db.lastfm.nosql.mongo.dao.LastfmArtistResultDAO;
import com.kwler.commons.db.lastfm.nosql.mongo.dao.LastfmArtistResultMorphiaDAO;
import com.kwler.commons.db.marketranking.nosql.mongo.dao.YoutubeMRArtistDAO;
import com.kwler.commons.db.marketranking.nosql.mongo.dao.YoutubeMRArtistMorphiaDAO;
import com.kwler.commons.db.marketranking.nosql.mongo.dao.YoutubeMRTrackDAO;
import com.kwler.commons.db.marketranking.nosql.mongo.dao.YoutubeMRTrackMorphiaDAO;
import com.kwler.commons.db.playlist.nosql.mongo.dao.PlaylistItemDAO;
import com.kwler.commons.db.playlist.nosql.mongo.dao.PlaylistItemMorphiaDAO;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.JobDAO;
import com.kwler.commons.db.scheduler.job.nosql.mongo.dao.JobMorphiaDAO;
import com.kwler.commons.db.soundcloud.nosql.mongo.dao.SoundcloudResultDAO;
import com.kwler.commons.db.soundcloud.nosql.mongo.dao.SoundcloudResultMorphiaDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifyAlbumDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifyAlbumMorphiaDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifyCountryListenerDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifyCountryListenerMorphiaDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifyResultDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifyResultMorphiaDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifySimilarDAO;
import com.kwler.commons.db.spotify.nosql.mongo.dao.SpotifySimilarMorphiaDAO;
import com.kwler.commons.db.twitter.nosql.mongo.dao.TwitterARDAO;
import com.kwler.commons.db.twitter.nosql.mongo.dao.TwitterARMorphiaDAO;
import com.kwler.commons.db.twitter.nosql.mongo.dao.TwitterEngagementResultGnipDAO;
import com.kwler.commons.db.twitter.nosql.mongo.dao.TwitterEngagementResultGnipMorphiaDAO;
import com.kwler.commons.db.twitter.nosql.mongo.dao.TwitterResultDAO;
import com.kwler.commons.db.twitter.nosql.mongo.dao.TwitterResultMorphiaDAO;
import com.kwler.commons.db.venue.nosql.mongo.dao.VenueItemDAO;
import com.kwler.commons.db.venue.nosql.mongo.dao.VenueItemMorphiaDAO;
import com.kwler.commons.db.worker.log.nosql.mongo.dao.WorkerLogDAO;
import com.kwler.commons.db.worker.log.nosql.mongo.dao.WorkerLogMorphiaDAO;
import com.kwler.commons.db.worker.log.nosql.mongo.dao.WorkerStatusDAO;
import com.kwler.commons.db.worker.log.nosql.mongo.dao.WorkerStatusMorphiaDAO;
import com.kwler.commons.db.youtube.nosql.mongo.dao.YoutubeResultDAO;
import com.kwler.commons.db.youtube.nosql.mongo.dao.YoutubeResultMorphiaDAO;
import com.kwler.commons.encoding.EncoderService;
import com.kwler.commons.http.ApacheHTTPClientService;
import com.kwler.commons.http.HttpClientService;
import com.kwler.commons.http.S3Service;
import com.kwler.commons.io.ProcessService;
import com.kwler.commons.io.PropertyService;
import com.kwler.commons.json.JsonService;
import com.kwler.commons.mail.service.MailService;
import com.kwler.commons.mail.service.MailgunService;
import com.kwler.commons.messaging.service.SQSService;
import com.kwler.commons.string.MustacheService;
import com.kwler.commons.string.StringService;
import com.kwler.commons.thread.ThreadService;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class CommonService {

	public static ServiceClass[] registerServices(){
		
		return new ServiceClass[]{
			new ServiceClass(HMacService.class)
			, new ServiceClass(MorphiaService.class)
			, new ServiceClass(DatetimeService.class)
			, new ServiceClass(EncoderService.class)
			, new ServiceClass(JsonService.class)
			, new ServiceClass(SQSService.class)
			, new ServiceClass(ProcessService.class)
			, new ServiceClass(StringService.class)
			, new ServiceClass(ThreadService.class)
			, new ServiceClass(PropertyService.class)
			, new ServiceClass(DigestService.class)
			, new ServiceClass(HttpClientService.class, ApacheHTTPClientService.class)
			, new ServiceClass(MailService.class, MailgunService.class)
			, new ServiceClass(ChartItemDAO.class, ChartItemMorphiaDAO.class)
			, new ServiceClass(PlaylistItemDAO.class, PlaylistItemMorphiaDAO.class)
			, new ServiceClass(VenueItemDAO.class, VenueItemMorphiaDAO.class)
			, new ServiceClass(JobDAO.class, JobMorphiaDAO.class)
			, new ServiceClass(FacebookResultDAO.class, FacebookResultMorphiaDAO.class)
			, new ServiceClass(InstagramResultDAO.class, InstagramResultMorphiaDAO.class)
			, new ServiceClass(LastfmArtistResultDAO.class, LastfmArtistResultMorphiaDAO.class)
			, new ServiceClass(SoundcloudResultDAO.class, SoundcloudResultMorphiaDAO.class)
			, new ServiceClass(TwitterResultDAO.class, TwitterResultMorphiaDAO.class)
			, new ServiceClass(TwitterARDAO.class, TwitterARMorphiaDAO.class)
			, new ServiceClass(TwitterEngagementResultGnipDAO.class, TwitterEngagementResultGnipMorphiaDAO.class)
			, new ServiceClass(SpotifyResultDAO.class, SpotifyResultMorphiaDAO.class)
			, new ServiceClass(SpotifySimilarDAO.class, SpotifySimilarMorphiaDAO.class)
			, new ServiceClass(SpotifyAlbumDAO.class, SpotifyAlbumMorphiaDAO.class)
			, new ServiceClass(ArtistDiscoveryDAO.class, ArtistDiscoveryMorphiaDAO.class)
			, new ServiceClass(WorkerLogDAO.class, WorkerLogMorphiaDAO.class)
			, new ServiceClass(YoutubeResultDAO.class, YoutubeResultMorphiaDAO.class)
			, new ServiceClass(BandsInTownDAO.class, BandsInTownMorphiaDAO.class)
			, new ServiceClass(BlogItemDAO.class, BlogItemMorphiaDAO.class)
			, new ServiceClass(FacebookPostResultDAO.class, FacebookPostResultMorphiaDAO.class)
			, new ServiceClass(FacebookEventResultDAO.class, FacebookEventResultMorphiaDAO.class)
			, new ServiceClass(ItunesResultDAO.class, ItunesResultMorphiaDAO.class)
			, new ServiceClass(YoutubeMRArtistDAO.class, YoutubeMRArtistMorphiaDAO.class)
			, new ServiceClass(YoutubeMRTrackDAO.class, YoutubeMRTrackMorphiaDAO.class)
			, new ServiceClass(ItunesResultDAO.class, ItunesResultMorphiaDAO.class)
			, new ServiceClass(ItunesResultSpotifyTrackDAO.class, ItunesResultSpotifyTrackMorphiaDAO.class)
			, new ServiceClass(SpotifyCountryListenerDAO.class, SpotifyCountryListenerMorphiaDAO.class)
			, new ServiceClass(ArtistSummaryDAO.class, ArtistSummaryMorphiaDAO.class)
			, new ServiceClass(WorkerStatusDAO.class, WorkerStatusMorphiaDAO.class)
			, new ServiceClass(S3Service.class)
			, new ServiceClass(MustacheService.class)
			, new ServiceClass(RequestSigner.class)
		};
		
	}
	
}
